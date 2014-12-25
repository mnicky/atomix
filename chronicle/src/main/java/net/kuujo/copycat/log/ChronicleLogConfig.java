/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.log;

import net.kuujo.copycat.Config;
import net.kuujo.copycat.internal.util.Assert;
import net.kuujo.copycat.spi.RetentionPolicy;

import java.io.File;

/**
 * Chronicle log configuration.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class ChronicleLogConfig extends LogConfig {
  public static final String CHRONICLE_LOG_INDEX_FILE_CAPACITY = "index.capacity";
  public static final String CHRONICLE_LOG_INDEX_FILE_EXCERPTS = "index.excerpts";
  public static final String CHRONICLE_LOG_DATA_BLOCK_SIZE = "block.size";
  public static final String CHRONICLE_LOG_MESSAGE_CAPACITY = "message.capacity";
  public static final String CHRONICLE_LOG_MINIMISE_FOOTPRINT = "minimize-footprint";

  private static final int DEFAULT_CHRONICLE_LOG_INDEX_FILE_CAPACITY = 1024 * 1024;
  private static final int DEFAULT_CHRONICLE_LOG_INDEX_FILE_EXCERPTS = 8 * 1024;
  private static final int DEFAULT_CHRONICLE_LOG_DATA_BLOCK_SIZE = 8 * 1024;
  private static final int DEFAULT_CHRONICLE_LOG_MESSAGE_CAPACITY = 8129 / 2;
  private static final boolean DEFAULT_CHRONICLE_LOG_MINIMISE_FOOTPRINT = false;

  public ChronicleLogConfig() {
  }

  public ChronicleLogConfig(Config config) {
    super(config);
  }

  @Override
  public ChronicleLogConfig copy() {
    return new ChronicleLogConfig(this);
  }

  /**
   * Sets the chronicle index file capacity.
   *
   * @param capacity The chronicle index file capacity.
   */
  public void setIndexFileCapacity(int capacity) {
    put(CHRONICLE_LOG_INDEX_FILE_CAPACITY, Assert.arg(capacity, capacity > 0, "index file capacity must be greater than zero"));
  }

  /**
   * Returns the chronicle index file capacity.
   *
   * @return The chronicle index file capacity.
   */
  public int getIndexFileCapacity() {
    return get(CHRONICLE_LOG_INDEX_FILE_CAPACITY, DEFAULT_CHRONICLE_LOG_INDEX_FILE_CAPACITY);
  }

  /**
   * Sets the chronicle index file capacity, returning the configuration for method chaining.
   *
   * @param capacity The chronicle index file capacity.
   * @return The chronicle log configuration.
   */
  public ChronicleLogConfig withIndexFileCapacity(int capacity) {
    setIndexFileCapacity(capacity);
    return this;
  }

  /**
   * Sets the number of chronicle index file excerpts.
   *
   * @param excerpts The number of chronicle index file excerpts.
   */
  public void setIndexFileExcerpts(int excerpts) {
    put(CHRONICLE_LOG_INDEX_FILE_EXCERPTS, Assert.arg(excerpts, excerpts > 0, "index file excerpts must be greater than zero"));
  }

  /**
   * Returns the number of chronicle index file excerpts.
   *
   * @return The number of chronicle index file excerpts.
   */
  public int getIndexFileExcerpts() {
    return get(CHRONICLE_LOG_INDEX_FILE_EXCERPTS, DEFAULT_CHRONICLE_LOG_INDEX_FILE_EXCERPTS);
  }

  /**
   * Sets the number of chronicle index file excerpts, returning the configuration for method chaining.
   *
   * @param excerpts The number of chronicle index file excerpts.
   * @return The chronicle log configuration.
   */
  public ChronicleLogConfig withIndexFileExcerpts(int excerpts) {
    setIndexFileExcerpts(excerpts);
    return this;
  }

  /**
   * Sets the chronicle data block size.
   *
   * @param blockSize The chronicle data block size.
   */
  public void setDataBlockSize(int blockSize) {
    put(CHRONICLE_LOG_DATA_BLOCK_SIZE, Assert.arg(blockSize, blockSize > 0, "data block size must be greater than zero"));
  }

  /**
   * Returns the chronicle data block size.
   *
   * @return The chronicle data block size.
   */
  public int getDataBlockSize() {
    return get(CHRONICLE_LOG_DATA_BLOCK_SIZE, DEFAULT_CHRONICLE_LOG_DATA_BLOCK_SIZE);
  }

  /**
   * Sets the chronicle data block size, returning the configuration for method chaining.
   *
   * @param blockSize The chronicle data block size.
   * @return The chronicle log configuration.
   */
  public ChronicleLogConfig withDataBlockSize(int blockSize) {
    setDataBlockSize(blockSize);
    return this;
  }

  /**
   * Sets the chronicle message capacity.
   *
   * @param capacity The chronicle message capacity.
   */
  public void setMessageCapacity(int capacity) {
    put(CHRONICLE_LOG_MESSAGE_CAPACITY, Assert.arg(capacity, capacity > 0, "message capacity must be greater than zero"));
  }

  /**
   * Returns the chronicle message capacity.
   *
   * @return The chronicle message capacity.
   */
  public int getMessageCapacity() {
    return get(CHRONICLE_LOG_MESSAGE_CAPACITY, DEFAULT_CHRONICLE_LOG_MESSAGE_CAPACITY);
  }

  /**
   * Sets the chronicle message capacity, returning the configuration for method chaining.
   *
   * @param capacity The chronicle message capacity.
   * @return The chronicle log configuration.
   */
  public ChronicleLogConfig withMessageCapacity(int capacity) {
    setMessageCapacity(capacity);
    return this;
  }

  /**
   * Sets whether to minimize the Chronicle log footprint.
   *
   * @param minimise Whether to minimize the chronicle log footprint.
   */
  public void setMinimiseFootprint(boolean minimise) {
    put(CHRONICLE_LOG_MINIMISE_FOOTPRINT, minimise);
  }

  /**
   * Returns whether Chronicle log footprint minimization is enabled.
   *
   * @return Indicates whether footprint minimization is enabled.
   */
  public boolean isMinimiseFootprint() {
    return get(CHRONICLE_LOG_MINIMISE_FOOTPRINT, DEFAULT_CHRONICLE_LOG_MINIMISE_FOOTPRINT);
  }

  /**
   * Sets whether to minimize the Chronicle log footprint, returning the configuration for method chaining.
   *
   * @param minimise Whether to minimize the chronicle log footprint.
   * @return The Chronicle log configuration.
   */
  public ChronicleLogConfig withMinimiseFootprint(boolean minimise) {
    setMinimiseFootprint(minimise);
    return this;
  }

  @Override
  public ChronicleLogConfig withName(String name) {
    super.setName(name);
    return this;
  }

  @Override
  public ChronicleLogConfig withDirectory(String directory) {
    super.setDirectory(directory);
    return this;
  }

  @Override
  public ChronicleLogConfig withDirectory(File directory) {
    super.setDirectory(directory);
    return this;
  }

  @Override
  public ChronicleLogConfig withSegmentSize(int segmentSize) {
    super.setSegmentSize(segmentSize);
    return this;
  }

  @Override
  public ChronicleLogConfig withSegmentInterval(long segmentInterval) {
    super.setSegmentInterval(segmentInterval);
    return this;
  }

  @Override
  public ChronicleLogConfig withFlushOnWrite(boolean flushOnWrite) {
    super.setFlushOnWrite(flushOnWrite);
    return this;
  }

  @Override
  public ChronicleLogConfig withFlushInterval(long flushInterval) {
    super.setFlushInterval(flushInterval);
    return this;
  }

  @Override
  public ChronicleLogConfig withRetentionPolicy(RetentionPolicy retentionPolicy) {
    super.setRetentionPolicy(retentionPolicy);
    return this;
  }

}